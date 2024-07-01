package vcs.vcsSetting

import jetbrains.buildServer.configs.kotlin.BuildType

fun BuildType.vcsSetting(){
    vcs {
        root(RelativeId("HttpsGithubComAjayKumar9375jsonRepoGitRefsHeadsMain", "+:. => HttpsGithubComAjayKumar9375jsonRepoGitRefsHeadsMain"))
    }
}