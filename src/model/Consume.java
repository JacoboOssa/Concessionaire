package model;

public interface Consume{
	public double calculateConsumeGasoline(double capacity,double cylinder);

	public double calculateConsumeBattery(double cylinder,double batteryDuration);
}