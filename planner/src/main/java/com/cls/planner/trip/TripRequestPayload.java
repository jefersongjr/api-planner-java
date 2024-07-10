package com.cls.planner.trip;

import java.util.List;

public record TripRequestPayload(String destination, String stars_at, String ends_at, List<String> emails_to_invite, String owner_name, String owner_email) {
}
