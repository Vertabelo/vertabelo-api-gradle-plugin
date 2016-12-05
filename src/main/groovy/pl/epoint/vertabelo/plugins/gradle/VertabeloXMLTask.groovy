package pl.epoint.vertabelo.plugins.gradle

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * 'vertabloXML' task class. Downloads XML script from Vertabelo API based on following parameters:
 * - apiToken : API token to Vertabelo user account
 * - modelId : Vertabelo model id
 * - modelTag : Vertabelo model version tag (optional)
 * - destSQLFile : XML file where model will be saved to
 *
 * @author Krzysztof Waraksa
 */
class VertabeloXMLTask extends DefaultTask {

    def GET_MODEL_ADDR = "https://my.vertabelo.com/api/xml"

    @TaskAction
    def void download() {
        def apiToken = project.vertabelo.apiToken
        def modelId = project.vertabelo.modelId
        def tag = project.vertabelo.modelTag
        def fileName = project.vertabelo.destXMLFile

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
