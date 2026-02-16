package com.vishnu.presence.dto;

public class SuspectSummaryDTO {

    private Long userId;
    private long suspectCount;

    public SuspectSummaryDTO(Long userId, long suspectCount) {
        this.userId = userId;
        this.suspectCount = suspectCount;
    }

    public Long getUserId() {
        return userId;
    }

    public long getSuspectCount() {
        return suspectCount;
    }
}
