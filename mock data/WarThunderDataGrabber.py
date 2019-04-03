"""
Author: Landon Patmore
"""

import json
import requests
from time import sleep
import signal
import sys

server = ""
currentAircraft = ""
plane_data = []

"""
Grabs data from War thunder server running and will throw exception if invalid server address
is input
Returns True if status code is 200 and the JSON coming back is valid, otherwise returns False
"""
def getData():
    try:
        state = requests.get("http://" + server + ":8111/state")
        indicators = requests.get("http://" + server + ":8111/indicators")
    except requests.exceptions.RequestException as e:
        print(e)
        sys.exit(-1)

    if (state.status_code == requests.codes.ok) and (indicators.status_code == requests.codes.ok):
        state_valid = state.json()["valid"]
        indicators_valid = indicators.json()["valid"]

        state_valid = state.json()["valid"]
        indicators_valid = indicators.json()["valid"]

        if state_valid and indicators_valid:
            if checkIfSamePlaneData(indicators.json()["type"]):
                data = {
                    "state": state.json(),
                    "indicators": indicators.json()
                }
                plane_data.append(data)
                return True
            else:
                return False
        else:
            return False
    else:
        print(state.status_code)
        sys.exit(-1)

"""
Checks to see if the current plane is the same as the new plane name
"""
def checkIfSamePlaneData(newAircraftName):
    if newAircraftName == "dummy_plane":
        return False

    global currentAircraft
    if len(currentAircraft) == 0:
        currentAircraft = newAircraftName
    
        return True
    
    if not (currentAircraft == newAircraftName):
        currentAircraft = newAircraftName
        return False
    else:
        return True

"""
Handles a CTRL + C command and then writes data to the designated file
"""
def signal_handler(sig, frame):
    writeToFile()
    sys.exit(0)

"""
Helper to write JSON data to a file
"""
def writeToFile():
    if len(plane_data) > 0:
        with open(currentAircraft + '_data.json', 'w') as outfile:
            json.dump(plane_data, outfile)
            plane_data.clear()
    else:
        print("No data to write...")

"""
Main function
"""
def main():
    global server 
    server = input("Server address: ")  

    signal.signal(signal.SIGINT, signal_handler)
    planeSelected = False
    while True:
        sleep(0.1)
        valid = getData()

        if valid:
            if not planeSelected:
                print(currentAircraft + " data collection has started...")
                planeSelected = True
        else:
            if planeSelected:
                print(currentAircraft + " data collection has ended...")
                planeSelected = False
                writeToFile()


if __name__ == "__main__":
    main()
