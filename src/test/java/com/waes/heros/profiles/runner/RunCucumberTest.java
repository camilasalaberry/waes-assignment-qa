package com.waes.heros.profiles.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty","json:target/cucumber.json"}, features = "src/test/resources/features", glue="com.waes.heros.profiles.steps")
public class RunCucumberTest {
}
