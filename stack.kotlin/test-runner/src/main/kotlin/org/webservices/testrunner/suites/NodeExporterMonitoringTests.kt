package org.webservices.testrunner.suites

import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import org.webservices.testrunner.framework.*

suspend fun TestRunner.nodeExporterMonitoringTests() = suite("Node Exporter Monitoring Tests") {
test("Node Exporter metrics endpoint") {
        val response = client.getRawResponse("http://node-exporter:9100/metrics")
        response.status shouldBe HttpStatusCode.OK
        val body = response.bodyAsText()
        body shouldContain "node_"  
        println("      ✓ Node Exporter providing system metrics")
    }
}
