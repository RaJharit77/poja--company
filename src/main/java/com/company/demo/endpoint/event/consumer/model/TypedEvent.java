package com.company.demo.endpoint.event.consumer.model;

import com.company.demo.PojaGenerated;
import com.company.demo.endpoint.event.model.PojaEvent;

@PojaGenerated
public record TypedEvent(String typeName, PojaEvent payload) {}
