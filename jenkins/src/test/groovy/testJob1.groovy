package com.lesfurets.jenkins

import com.lesfurets.jenkins.helpers.BaseRegressionTest
import org.junit.Before
import org.junit.Test

class TestJobRandoriPipeline extends BaseRegressionTest {

    @Override
    @Before
    void setUp() throws Exception {
        // See https://github.com/lesfurets/pipeline-test-helper/blob/master/src/test/groovy/com/lesfurets/jenkins/TestExampleJob.groovy
        helper.scriptRoots += 'src/main'
        helper.baseScriptRoot = 'jenkins/'
        super.setUp()
    }

    @Test
    void testNonRegression() {
        def script = loadScript("src/main/job/randoriPipeline.jenkins")
        script.execute()
        super.testNonRegression(false)
    }

    @Test
    void testRandori() throws Exception {
        def scriptLoader = loadScript('lib/scriptLoader.jenkins')
        def script = scriptLoader.configure('job/randoriPipeline.jenkins')
        script.execute()
        printCallStack()
    }
}