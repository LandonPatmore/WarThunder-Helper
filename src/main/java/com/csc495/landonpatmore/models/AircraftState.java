package com.csc495.landonpatmore.models;

public class AircraftState {
    private boolean valid;
//    private int engineNum;
    private int altitude;
    private int aileronPercentage;
    private int elevatorPercentage;
    private int rudderPercentage;
    private int flapsPercentage;
    private int gearPercentage;
    private int TAS;
    private int IAS;
    private double M;
    private double AoA;
    private double AoS;
    private double Ny;
    private double Vy;
    private double Wx;
    private int throttle;
    private int RPMthrottle;
    private int radiator;
    private int mixture;
    private int compressorstage;
    private int magenato;
    private double power[];
    private int RPM;
    private double manifoldpressure;
    private double watertemp;
    private double oiltemp;
    private double pitch[];
    private int thrust[];
    private double efficiency[];

    public AircraftState() {
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

//    public int getEngineNum() {
//        return engineNum;
//    }
//
//    public void setEngineNum(int engineNum) {
//        this.engineNum = engineNum;
//    }

    public int getAileronPercentage() {
        return aileronPercentage;
    }

    public void setAileronPercentage(int aileronPercentage) {
        this.aileronPercentage = aileronPercentage;
    }

    public int getElevatorPercentage() {
        return elevatorPercentage;
    }

    public void setElevatorPercentage(int elevatorPercentage) {
        this.elevatorPercentage = elevatorPercentage;
    }

    public int getRudderPercentage() {
        return rudderPercentage;
    }

    public void setRudderPercentage(int rudderPercentage) {
        this.rudderPercentage = rudderPercentage;
    }

    public int getFlapsPercentage() {
        return flapsPercentage;
    }

    public void setFlapsPercentage(int flapsPercentage) {
        this.flapsPercentage = flapsPercentage;
    }

    public int getGearPercentage() {
        return gearPercentage;
    }

    public void setGearPercentage(int gearPercentage) {
        this.gearPercentage = gearPercentage;
    }

    public int getTAS() {
        return TAS;
    }

    public void setTAS(int TAS) {
        this.TAS = TAS;
    }

    public int getIAS() {
        return IAS;
    }

    public void setIAS(int IAS) {
        this.IAS = IAS;
    }

    public double getM() {
        return M;
    }

    public void setM(double m) {
        M = m;
    }

    public double getAoA() {
        return AoA;
    }

    public void setAoA(double aoA) {
        AoA = aoA;
    }

    public double getAoS() {
        return AoS;
    }

    public void setAoS(double aoS) {
        AoS = aoS;
    }

    public double getNy() {
        return Ny;
    }

    public void setNy(double ny) {
        Ny = ny;
    }

    public double getVy() {
        return Vy;
    }

    public void setVy(double vy) {
        Vy = vy;
    }

    public double getWx() {
        return Wx;
    }

    public void setWx(double wx) {
        Wx = wx;
    }

    public int getThrottle() {
        return throttle;
    }

    public void setThrottle(int throttle) {
        this.throttle = throttle;
    }

    public int getRPMthrottle() {
        return RPMthrottle;
    }

    public void setRPMthrottle(int RPMthrottle) {
        this.RPMthrottle = RPMthrottle;
    }

    public int getRadiator() {
        return radiator;
    }

    public void setRadiator(int radiator) {
        this.radiator = radiator;
    }

    public int getMixture() {
        return mixture;
    }

    public void setMixture(int mixture) {
        this.mixture = mixture;
    }

    public int getCompressorstage() {
        return compressorstage;
    }

    public void setCompressorstage(int compressorstage) {
        this.compressorstage = compressorstage;
    }

    public int getMagenato() {
        return magenato;
    }

    public void setMagenato(int magenato) {
        this.magenato = magenato;
    }

    public double[] getPower() {
        return power;
    }

    public void setPower(double[] power) {
        this.power = power;
    }

    public int getRPM() {
        return RPM;
    }

    public void setRPM(int RPM) {
        this.RPM = RPM;
    }

    public double getManifoldpressure() {
        return manifoldpressure;
    }

    public void setManifoldpressure(double manifoldpressure) {
        this.manifoldpressure = manifoldpressure;
    }

    public double getWatertemp() {
        return watertemp;
    }

    public void setWatertemp(double watertemp) {
        this.watertemp = watertemp;
    }

    public double getOiltemp() {
        return oiltemp;
    }

    public void setOiltemp(double oiltemp) {
        this.oiltemp = oiltemp;
    }

    public double[] getPitch() {
        return pitch;
    }

    public void setPitch(double[] pitch) {
        this.pitch = pitch;
    }

    public int[] getThrust() {
        return thrust;
    }

    public void setThrust(int[] thrust) {
        this.thrust = thrust;
    }

    public double[] getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(double[] efficiency) {
        this.efficiency = efficiency;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }
}
