package org.webservices.testrunner.suites

import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import org.webservices.testrunner.framework.*

suspend fun TestRunner.nodeExporterMonitoringTests() = suite("Node Exporter Monitoring Tests") {
test("Node Exporter metrics endpoint") {
        val response = client.postRaw("${env.endpoints.prometheus}/api/v1/query?query=up{job=\"node-exporter\"}")
        response.status shouldBe HttpStatusCode.OK
        val body = response.bodyAsText()
        body shouldContain "node-exporter"
        println("      ✓ Node Exporter scrape target is available through Prometheus")
    }
}
