import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.perfmon
import jetbrains.buildServer.configs.kotlin.buildSteps.python
import jetbrains.buildServer.configs.kotlin.triggers.vcs
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2024.03"

project {

    vcsRoot(HttpsGithubComAjayKumar9375jsonRepoGitRefsHeadsMain1)
    vcsRoot(HttpsGithubComAjayKumar9375jsonRepoGitRefsHeadsMain)

    buildType(Feature1)
    buildType(Feature2_2)
}

object Feature1 : BuildType({
    name = "feature1"

    artifactRules = "json_destination.json"

    vcs {
        root(HttpsGithubComAjayKumar9375jsonRepoGitRefsHeadsMain)
    }

    steps {
        python {
            id = "python_runner"
            command = file {
                filename = "main.py"
                scriptArguments = "--path_to_source_json_file %source% --path_to_destination_json_file %destination% --location_one %location1% --location_two %location2%"
            }
        }
    }

    triggers {
        vcs {
        }
    }

    features {
        perfmon {
        }
    }
})

object Feature2_2 : BuildType({
    name = "feature2"

    vcs {
        root(HttpsGithubComAjayKumar9375jsonRepoGitRefsHeadsMain1)
    }

    steps {
        python {
            id = "python_runner"
            command = file {
                filename = "main.py"
                scriptArguments = "--path_to_source_json_file %source% --path_to_destination_json_file %destination% --location_one %location1% --location_two %location2%"
            }
        }
    }

    triggers {
        vcs {
        }
    }

    features {
        perfmon {
        }
    }
})

object HttpsGithubComAjayKumar9375jsonRepoGitRefsHeadsMain : GitVcsRoot({
    name = "https://github.com/AjayKumar9375/json_repo.git#refs/heads/main"
    url = "https://github.com/AjayKumar9375/json_repo.git"
    branch = "refs/heads/main"
    branchSpec = "refs/heads/*"
})

object HttpsGithubComAjayKumar9375jsonRepoGitRefsHeadsMain1 : GitVcsRoot({
    name = "https://github.com/AjayKumar9375/json_repo.git#refs/heads/main (1)"
    url = "https://github.com/AjayKumar9375/json_repo.git"
    branch = "refs/heads/main"
    branchSpec = "refs/heads/*"
})
