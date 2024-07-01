package vcs
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot


object HttpsGithubComAjayKumar9375jsonRepoGitRefsHeadsMain : GitVcsRoot({
    id("HttpsGithubComAjayKumar9375jsonRepoGitRefsHeadsMain")
    name = "https://github.com/AjayKumar9375/json_repo.git#refs/heads/main"
    url = "https://github.com/AjayKumar9375/json_repo.git"
    branch = "refs/heads/main"
    branchSpec = "refs/heads/*"
})