// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.drive;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.SPI;

public class GyroNavXIO implements GyroIO {
  /** Creates a new NavXIO. */
  private final AHRS m_NavX = new AHRS(SPI.Port.kMXP, (byte) 200);

  public GyroNavXIO() {}

  public void updateInputs(GyroIOInputs inputs) {
    inputs.connected = m_NavX.isConnected();
    inputs.yawPosition = Rotation2d.fromDegrees(m_NavX.getYaw());
    inputs.yawVelocityRadPerSec = Units.degreesToRadians(m_NavX.getVelocityY());
  }
}
