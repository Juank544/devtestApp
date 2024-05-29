package com.siigroup.thales.devtest.model.dto;

import java.io.Serializable;

public record DummyDTO(String status,Object data, String message) implements Serializable {
}
