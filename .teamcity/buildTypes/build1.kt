package DslTesting.buildTypes


import DslTesting.DslBuildStep.*

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.python
import jetbrains.buildServer.configs.kotlin.failureConditions.BuildFailureOnText
import jetbrains.buildServer.configs.kotlin.failureConditions.failOnText
import jetbrains.buildServer.configs.kotlin.triggers.vcs


class DslTesting_BuildTypes( 
    name: String, 
    description: String,
    artifactRules: String) : BuildType({

        fun String.toExtId(prefix: String = ""): String {
            val id = this.replace(" ", "")
            return if (prefix.isEmpty()) id else "$prefix$id"
        }
    id(name.toExtId())
    this.name = name
    this.description = description
    this.artifactRules = artifactRules

    params {
        param("destination", "json_destination.json")
        param("location1", "PlantModel")
        param("location2", "Bsc")
        param("Organization", "KPIT")
        param("source", "json_source.json")
    }



    vcs {
        root(DslTesting.vcsRoots.DslTesting_HttpsGithubComAjayKumar9375dslTestingGitRefsHeadsMain)
    }


    steps {

        pythonScrip()


    }

         triggers {
         vcs {
              branchFilter = ""
         }
     }

    failureConditions {
        failOnText {
            conditionType = BuildFailureOnText.ConditionType.CONTAINS
            pattern = "Key not found"
            failureMessage = "Key didn't match"
            reverse = false
            stopBuildOnFailure = true
        }
    }


})

