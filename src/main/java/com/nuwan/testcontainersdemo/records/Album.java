package com.nuwan.testcontainersdemo.records;

import java.util.List;

public record Album(Long albumId, List<Photo> photos) {}