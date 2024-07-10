package com.cls.planner.trip.participant;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class ParticipantService {

    public void registerPaticipantsToEvent(List<String> emails, UUID tripId) {
    }

    public void triggerConfirmationEmailToParticipants(UUID tripId) {
    }
}