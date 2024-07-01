package vcs.vcsSetting

import jetbrains.buildServer.configs.kotlin.BuildType
import jetbrains.buildServer.configs.kotlin.RelativeId


fun BuildType.vcsSetting(){
    vcs {
        root(RelativeId("HttpsGithubComAjayKumar9375jsonRepoGitRefsHeadsMain", "+:. => HttpsGithubComAjayKumar9375jsonRepoGitRefsHeadsMain"))
    }
}