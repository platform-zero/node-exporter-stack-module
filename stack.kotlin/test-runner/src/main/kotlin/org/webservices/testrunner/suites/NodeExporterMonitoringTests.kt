package org.webservices.testrunner.suites

import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import org.webservices.testrunner.framework.*

suspend fun TestRunner.nodeExporterMonitoringTests() = suite("Node Exporter Monitoring Tests") {
test("Node Exporter metrics endpoint") {
        val endpoint = System.getenv("NODE_EXPORTER_URL")
            ?.trim()
            ?.trimEnd('/')
            ?.takeIf { it.isNotEmpty() }
            ?: "http://host.containers.internal:19100"
        val response = client.getRawResponse("$endpoint/metrics")
        response.status shouldBe HttpStatusCode.OK
        val body = response.bodyAsText()
        body shouldContain "node_"  
        println("      ✓ Node Exporter providing system metrics")
    }
}
