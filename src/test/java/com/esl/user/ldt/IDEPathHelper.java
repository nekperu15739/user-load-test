package com.esl.user.ldt;

import java.nio.file.Path;
import java.nio.file.Paths;

public class IDEPathHelper {
    public static final Path projectRootDir = Paths.get(System.getProperty("user.dir"));
    public static final Path mavenSourcesDirectory = projectRootDir.resolve("src").resolve("test").resolve("java");
    public static final Path mavenResourcesDirectory = projectRootDir.resolve("src").resolve("test").resolve("resources");
    public static final Path resultsDirectory = projectRootDir.resolve("target").resolve("gatling");
    public static final Path recorderConfigFile = mavenResourcesDirectory.resolve("recorder.conf");
}
