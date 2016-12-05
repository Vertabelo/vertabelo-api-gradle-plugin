package pl.epoint.vertabelo.plugins.gradle

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
/**
 * 'vertabloSQL' task class. Downloads SQL script from Vertabelo API based on following parameters:
 * - apiToken : API token to Vertabelo user account
 * - modelId : Vertabelo model id
 * - modelTag : vertabelo model version tag (optional)
 * - destSQLFile : file where SQL script will be saved to
 *
 * @author Krzysztof Waraksa
 */
class VertabeloSQLTask extends DefaultTask {

    def GET_MODEL_ADDR = "https://my.vertabelo.com/api/sql"

    @TaskAction
    def void download() {
        def apiToken = project.vertabelo.apiToken
        def modelId = project.vertabelo.modelId
        def tag = project.vertabelo.modelTag
        def fileName = project.vertabelo.destSQLFile

        if (apiToken == null) {
            ant.fail("Vertabelo api token not set")
        }
        if (modelId == null) {
            ant.fail("Vertabelo model id not set")
        }

        def request;
        if (tag != null) {
            request = GET_MODEL_ADDR + "/" + modelId + "/" + tag
        } else {
            request = GET_MODEL_ADDR + "/" + modelId
        }

        new File(fileName.toString()).parentFile.mkdirs()

        def ant = new AntBuilder()
        ant.get(src: request,
                dest: fileName,
                username: apiToken)
    }

}
