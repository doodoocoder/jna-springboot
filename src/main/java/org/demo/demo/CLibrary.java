package org.demo.demo;

import com.sun.jna.win32.StdCallLibrary;

public interface CLibrary extends StdCallLibrary {

        void printf(String format, Object... args);
    }