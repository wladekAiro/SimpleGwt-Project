package com.wladek.project.client;

import com.google.gwt.junit.client.GWTTestCase;

public class SandboxGwtTest extends GWTTestCase {
    @Override
    public String getModuleName() {
        return "com.wladek.project.movies";
    }

    public void testSandbox() {
        assertTrue(true);
    }
}