package by.clever.gradle.plugin

import org.eclipse.jgit.api.Git
import org.eclipse.jgit.lib.ObjectId
import org.eclipse.jgit.lib.Repository
import org.eclipse.jgit.revwalk.RevCommit
import org.eclipse.jgit.revwalk.RevWalk
import org.eclipse.jgit.storage.file.FileRepositoryBuilder
import org.gradle.api.DefaultTask
import org.gradle.api.Plugin
import org.gradle.api.Project

class MyPlugin implements Plugin<Project> {

    @Override
    void apply(Project target) {

        def map = [description: "my task", group: "clever-gradle", type: DefaultTask]

        target.task(map, "mytask")  {

            FileRepositoryBuilder builder = new FileRepositoryBuilder()

            Repository repository = builder
                    .readEnvironment()
                    .findGitDir(new File("D:/Java study/4 Clevertec/Tasks/3 Gradle/Solution/CleverGradleTask"))
                    .build()

            Git git = new Git(repository)
            ObjectId objectId = repository.resolve("HEAD")
            RevWalk walk = new RevWalk(repository)
            RevCommit commit = walk.parseCommit(objectId)
            String tagName = git.describe().setTarget(objectId).call()

            if (tagName == null) {
                git.tag().setObjectId(commit).setName("1.0").call()
            } else {
                String[] splittedTagName = tagName.split("\\.", 2)
                int majorTagName = Integer.parseInt(splittedTagName[0])
                int newTag = ++majorTagName
                git.tagDelete().setTags(tagName).call()
                git.tag().setObjectId(commit).setName(newTag.toString() + ".0").call()
            }
        }
    }
}