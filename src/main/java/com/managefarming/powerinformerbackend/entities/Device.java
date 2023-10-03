package com.managefarming.powerinformerbackend.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.managefarming.powerinformerbackend.enums.PowerStatus;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import java.time.ZoneId;
import java.time.ZonedDateTime;


@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name ="device")

public class Device {

    @Id
    @GeneratedValue
    @Column(name = "device_id")
    private Long deviceId;



    @Column(name = "device_name")
    private String deviceName;

    @Column(name = "device_auth_code")
    private String deviceAuthCode;

    @Enumerated(EnumType.STRING)
    @Column(name = "current_device_status")
    private PowerStatus currentDeviceStatus;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd@HH:mm:ss",locale = "en_IN")
    @Column(name = "last_heartbeat_signal")
    private ZonedDateTime lastHeartBeatSignal;

    @Column(name = "is_activated", columnDefinition = "boolean default true")
    private Boolean isActivated;

    @Column(name = "alert_start_time",columnDefinition = "varchar(5) default '00:00'")
    private String alertStartTime;

    @Column(name = "alert_end_time", columnDefinition = "varchar(5) default '00:00'")
    private String alertEndTime;

    @Column(name = "minutes_delay_to_notify", columnDefinition = "integer default 2")
    private int minutesDelayToNotify;

    @Column(name = "num_days_log_keeping", columnDefinition = "integer default 1")
    private int numDaysLogKeeping;





//    public Device(long farmId, String name, String deviceAuthCode, PowerStatus currentStatus, ZonedDateTime lastHeartBeatSignal) {
//        this.farmId = farmId;
//        this.name = name;
//        this.deviceAuthCode = deviceAuthCode;
//        this.currentStatus = currentStatus;
//        this.lastHeartBeatSignal = ZonedDateTime.now(ZoneId.of("Asia/Kolkata")).minusDays(1);
//    }
}
