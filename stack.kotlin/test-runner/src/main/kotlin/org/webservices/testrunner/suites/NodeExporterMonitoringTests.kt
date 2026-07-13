package org.webservices.testrunner.suites

import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import org.webservices.testrunner.framework.*

suspend fun TestRunner.nodeExporterMonitoringTests() = suite("Node Exporter Monitoring Tests") {
test("Node Exporter metrics endpoint") {
        val response = client.postRaw("${env.endpoints.prometheus}/api/v1/query?query=node_uname_info")
        response.status shouldBe HttpStatusCode.OK
        val body = response.bodyAsText()
        body shouldContain "node_uname_info"
        println("      ✓ Node Exporter metrics are available through Prometheus")
    }
}
