package com.ebson.skillserver.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
// import javax.persistence.*;

import java.nio.ByteBuffer;
import java.util.UUID;


@Converter(autoApply = true) // 이 컨버터를 자동으로 적용하도록 설정합니다.
public class UUIDToBytesConverter implements AttributeConverter<UUID, byte[]> {

    @Override
    // UUID 객체를 데이터베이스 컬럼에 저장하기 위해 byte[]로 변환합니다.
    public byte[] convertToDatabaseColumn(UUID uuid) {
        if (uuid == null) {
            return null; // UUID가 null이면, null을 반환합니다.
        }
        // UUID의 가장 중요한 비트(상위 64비트)를 가져옵니다.
        long mostSigBits = uuid.getMostSignificantBits();
        // UUID의 가장 적은 중요한 비트(하위 64비트)를 가져옵니다.
        long leastSigBits = uuid.getLeastSignificantBits();
        // ByteBuffer를 사용하여 byte 배열에 UUID의 비트를 저장합니다.
        return ByteBuffer.allocate(16) // UUID는 총 128비트이므로, 16바이트 배열을 할당합니다.
                .putLong(mostSigBits) // 상위 64비트를 byte 배열에 추가합니다.
                .putLong(leastSigBits) // 하위 64비트를 byte 배열에 추가합니다.
                .array(); // ByteBuffer를 byte 배열로 변환합니다.
    }

    @Override
    // 데이터베이스의 byte[]를 애플리케이션에서 사용하기 위해 UUID 객체로 변환합니다.
    public UUID convertToEntityAttribute(byte[] bytes) {
        if (bytes == null || bytes.length != 16) {
            return null; // byte 배열이 null이거나 길이가 16바이트가 아니면, null을 반환합니다.
        }
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes); // byte 배열을 ByteBuffer로 감쌉니다.
        // ByteBuffer에서 상위 64비트(가장 중요한 비트)를 읽어옵니다.
        long mostSigBits = byteBuffer.getLong();
        // ByteBuffer에서 하위 64비트(가장 적은 중요한 비트)를 읽어옵니다.
        long leastSigBits = byteBuffer.getLong();
        // 읽어온 비트를 사용하여 새로운 UUID 객체를 생성합니다.
        return new UUID(mostSigBits, leastSigBits);
    }
}
