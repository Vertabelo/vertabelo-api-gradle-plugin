package pl.epoint.vertabelo.plugins.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Plugin class of Vertabelo Gradle plugin.
 *
 * @author Krzysztof Waraksa
 */
class VertabeloPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.task('vertabeloSQL', type: VertabeloSQLTask)
        project.task('vertabeloXML', type: VertabeloXMLTask)
        project.extensions.create('vertabelo', VertabeloExtension)
    }
}
