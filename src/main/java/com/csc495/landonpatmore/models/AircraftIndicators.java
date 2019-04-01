package com.csc495.landonpatmore.models;

public class AircraftIndicators {
    private boolean valid;
    private double aviahorizon_roll;
    private double aviahorizon_pitch;
    private String type;
    private boolean isdummyplane;
    private String stype;
    private boolean flag;
    private double speed;
    private double pedals;
    private double stick_elevator;
    private double stick_ailerons;
    private double altitude_hour;
    private double altitude_min;
    private double altitude_10k;
    private double bank;
    private double turn;
    private double compass;
    private double clock_hour;
    private double clock_min;
    private double clock_sec;
    private double manifold_pressure;
    private double rpm;
    private double oil_pressure;
    private double water_temperature;
    private double engine_temperature;
    private double mixture;
    private double fuel[];
    private double fuel_pressure;
    private double oxygen;
    private double gears_lamp;
    private double flaps;
    private double trimmer;
    private double throttle;
    private double weapon1;
    private double weapon2;
    private double weapon3;
    private double prop_pitch_hour;
    private double prop_pitch_min;
    private double ammo_counter1;
    private double ammo_counter2;
    private double ammo_counter3;
    private int fuelnum;

    public AircraftIndicators() {
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isIsdummyplane() {
        return isdummyplane;
    }

    public void setIsdummyplane(boolean isdummyplane) {
        this.isdummyplane = isdummyplane;
    }

    public String getStype() {
        return stype;
    }

    public void setStype(String stype) {
        this.stype = stype;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getPedals() {
        return pedals;
    }

    public void setPedals(double pedals) {
        this.pedals = pedals;
    }

    public double getStick_elevator() {
        return stick_elevator;
    }

    public void setStick_elevator(double stick_elevator) {
        this.stick_elevator = stick_elevator;
    }

    public double getStick_ailerons() {
        return stick_ailerons;
    }

    public void setStick_ailerons(double stick_ailerons) {
        this.stick_ailerons = stick_ailerons;
    }

    public double getAltitude_hour() {
        return altitude_hour;
    }

    public void setAltitude_hour(double altitude_hour) {
        this.altitude_hour = altitude_hour;
    }

    public double getAltitude_min() {
        return altitude_min;
    }

    public void setAltitude_min(double altitude_min) {
        this.altitude_min = altitude_min;
    }

    public double getAltitude_10k() {
        return altitude_10k;
    }

    public void setAltitude_10k(double altitude_10k) {
        this.altitude_10k = altitude_10k;
    }

    public double getBank() {
        return bank;
    }

    public void setBank(double bank) {
        this.bank = bank;
    }

    public double getTurn() {
        return turn;
    }

    public void setTurn(double turn) {
        this.turn = turn;
    }

    public double getCompass() {
        return compass;
    }

    public void setCompass(double compass) {
        this.compass = compass;
    }

    public double getClock_hour() {
        return clock_hour;
    }

    public void setClock_hour(double clock_hour) {
        this.clock_hour = clock_hour;
    }

    public double getClock_min() {
        return clock_min;
    }

    public void setClock_min(double clock_min) {
        this.clock_min = clock_min;
    }

    public double getClock_sec() {
        return clock_sec;
    }

    public void setClock_sec(double clock_sec) {
        this.clock_sec = clock_sec;
    }

    public double getManifold_pressure() {
        return manifold_pressure;
    }

    public void setManifold_pressure(double manifold_pressure) {
        this.manifold_pressure = manifold_pressure;
    }

    public double getRpm() {
        return rpm;
    }

    public void setRpm(double rpm) {
        this.rpm = rpm;
    }

    public double getOil_pressure() {
        return oil_pressure;
    }

    public void setOil_pressure(double oil_pressure) {
        this.oil_pressure = oil_pressure;
    }

    public double getWater_temperature() {
        return water_temperature;
    }

    public void setWater_temperature(double water_temperature) {
        this.water_temperature = water_temperature;
    }

    public double getEngine_temperature() {
        return engine_temperature;
    }

    public void setEngine_temperature(double engine_temperature) {
        this.engine_temperature = engine_temperature;
    }

    public double getMixture() {
        return mixture;
    }

    public void setMixture(double mixture) {
        this.mixture = mixture;
    }

    public double[] getFuel() {
        return fuel;
    }

    public void setFuel(double[] fuel) {
        this.fuel = fuel;
    }

    public double getFuel_pressure() {
        return fuel_pressure;
    }

    public void setFuel_pressure(double fuel_pressure) {
        this.fuel_pressure = fuel_pressure;
    }

    public double getOxygen() {
        return oxygen;
    }

    public void setOxygen(double oxygen) {
        this.oxygen = oxygen;
    }

    public double getGears_lamp() {
        return gears_lamp;
    }

    public void setGears_lamp(double gears_lamp) {
        this.gears_lamp = gears_lamp;
    }

    public double getFlaps() {
        return flaps;
    }

    public void setFlaps(double flaps) {
        this.flaps = flaps;
    }

    public double getTrimmer() {
        return trimmer;
    }

    public void setTrimmer(double trimmer) {
        this.trimmer = trimmer;
    }

    public double getThrottle() {
        return throttle;
    }

    public void setThrottle(double throttle) {
        this.throttle = throttle;
    }

    public double getWeapon1() {
        return weapon1;
    }

    public void setWeapon1(double weapon1) {
        this.weapon1 = weapon1;
    }

    public double getWeapon2() {
        return weapon2;
    }

    public void setWeapon2(double weapon2) {
        this.weapon2 = weapon2;
    }

    public double getWeapon3() {
        return weapon3;
    }

    public void setWeapon3(double weapon3) {
        this.weapon3 = weapon3;
    }

    public double getProp_pitch_hour() {
        return prop_pitch_hour;
    }

    public void setProp_pitch_hour(double prop_pitch_hour) {
        this.prop_pitch_hour = prop_pitch_hour;
    }

    public double getProp_pitch_min() {
        return prop_pitch_min;
    }

    public void setProp_pitch_min(double prop_pitch_min) {
        this.prop_pitch_min = prop_pitch_min;
    }

    public double getAmmo_counter1() {
        return ammo_counter1;
    }

    public void setAmmo_counter1(double ammo_counter1) {
        this.ammo_counter1 = ammo_counter1;
    }

    public double getAmmo_counter2() {
        return ammo_counter2;
    }

    public void setAmmo_counter2(double ammo_counter2) {
        this.ammo_counter2 = ammo_counter2;
    }

    public double getAmmo_counter3() {
        return ammo_counter3;
    }

    public void setAmmo_counter3(double ammo_counter3) {
        this.ammo_counter3 = ammo_counter3;
    }

    public int getFuelnum() {
        return fuelnum;
    }

    public void setFuelnum(int fuelnum) {
        this.fuelnum = fuelnum;
    }

    public double getAviahorizon_roll() {
        return aviahorizon_roll;
    }

    public void setAviahorizon_roll(double aviahorizon_roll) {
        this.aviahorizon_roll = aviahorizon_roll;
    }

    public double getAviahorizon_pitch() {
        return aviahorizon_pitch;
    }

    public void setAviahorizon_pitch(double aviahorizon_pitch) {
        this.aviahorizon_pitch = aviahorizon_pitch;
    }
}
