# RDC - Real DE4A Connector

This is the implementation of the DE4A Connector based on the TOOP Connector. It includes [phase4](https://github.com/phax/phase4) as the AS4 gateway for sending and receiving messages.

The thing is just called "Connector" in the rest of the documentation.

The content of this repository is dually licensed under the Apache 2.0 license and the EUPL 1.2.

## Goals and non-goals

The goals of the Connector are as follows:
* Encapsulate the calls of common interfaces
* Be able to send and receive any kind of payload, for any kind of transmission pattern (IM, USI, ...)
* Provide a solution that can be used in DE4A and later in the context of SDG as well
* Be technically integrable in as many ways as possible
* Be technically compatible with the WP5 DE4A Connector

The following are non-goals of the Connector:
* Provide a one-size fits all solution for all DE4A pilots - the specific workflow orchestrations are out of scope of this project
* Provide support for alternative AS4 gateways

## Functionalities

## Structure

RDC is structured in the following sub-modules:

* `rdc-api` - contains all generic interfaces for the message exchange etc. This project may be included as a dependency when programming against RDC.
* `rdc-core` - contains the main implementation logic, the configuration, the phase4 AS4 integration, the SMP lookup etc. This module can be integrated into other applications to have the full functionality in a Java API.
* `rdc-web-api` - contains the web integration of the core components (REST APIs), but only as a solution to be integrated (library) and not self-contained. This may be used to provide alternative implementations in another web application. Compared to `rdc-core` it offers an HTTP API.
* `rdc-webapp` - is a standalone web application (WAR) to be deployed in a Java JEE application server like Tomcat or Jetty, based on the `rdc-web-api` project. It may also serve as the basis for Docker images.

## Running the Connector

To be described

### Integration

There are different ways how to integrate the Connector into your environment.
The two main ways to do it is, to
1. run the Connector solution standalone - this could mean you take the binary WAR file and run it in the JEE application service server of your choice (or a derived Docker image)
1. integrate the Connector into your Java application that uses Servlet technology (required for AS4). Depending on your application needs you can either 
    * Integrate `rdc-core` if you are building an application that does not require an external HTTP interface
    * Integrate `rdc-web-api` if you are building a Servlet-based JEE application and you want to use the external HTTP interfaces but don't want to use the pre-build web application

## Developing the Connector

### Prerequisites

* Java 1.8 or higher
* Apache Maven 3.6 or higher as build tool

### Dependencies

This lists the major dependencies for the Connector specific dependent libraries.

* [phax/peppol-commons](https://github.com/phax/peppol-commons) is used for the consistent identifier handling as well as for the SMP client, required for the dynamic discovery
* [phax/ph-regrep](https://github.com/phax/ph-regrep) is used to create the RegRep representation
* [phax/phase4](https://github.com/phax/phase4) is used as the built-in AS4 gateway for sending and receiving messages, based on the [CEF AS4](https://ec.europa.eu/cefdigital/wiki/display/CEFDIGITAL/eDelivery+AS4+-+1.15) profile
* [de4a-wp5/de4a-commons](https://github.com/de4a-wp5/de4a-commons) is used for the Kafka integration
