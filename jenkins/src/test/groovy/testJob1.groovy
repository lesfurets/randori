package com.lesfurets.jenkins

import com.lesfurets.jenkins.helpers.BaseRegressionTest
import org.assertj.core.api.Assertions
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
    void testRandori() throws Exception {
        helper.registerAllowedMethod('sh', [Map.class], {"origin/hvinet\norigin/older_branch"})
        def scriptLoader = loadScript('lib/scriptLoader.jenkins')
        def script = scriptLoader.configure('job/randoriPipeline.jenkins')
        script.execute()
        printCallStack()
        super.testNonRegression(false)
    }

    @Test
    void getBranchList_should_map_to_Branch() throws Exception {
        helper.registerAllowedMethod('sh', [Map.class], {"origin/hvinet\norigin/older_branch"})
        def scriptLoader = loadScript('lib/scriptLoader.jenkins')
        def script = scriptLoader.configure('job/randoriPipeline.jenkins')

        List list = script.getBranchList("origin/hvinet\n" +
                "origin/older_branch")
        Assertions.assertThat(list).hasSize(2)
    }

    @Test(expected = Exception.class)
    void testErreurRandori() throws Exception {
        def script = loadScript("src/main/job/randoriPipeline.jenkins")
        script.execute()
    }

}