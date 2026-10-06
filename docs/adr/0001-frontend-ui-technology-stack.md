# ADR 0001: Frontend UI Technology Stack (Revision 2)

## Date
2026-10-06

## Status
Accepted (Supersedes previous Tailwind CSS / shadcn decision)

## Context
The school management system requires a robust, scalable web 
interface to interact with an event-driven backend architecture 
(Spring Boot microservices, Kafka, PostgreSQL). 

An initial decision was made to utilize Tailwind CSS and 
shadcn/ui. However, persistent path resolution bugs within the 
CLI tooling on Windows environments caused unacceptable friction 
during environment bootstrapping. Furthermore, as this system is 
designed to reflect an enterprise-grade architectural standard, 
we need a component library that inherently supports complex, 
data-heavy dashboard layouts with minimal manual CSS authoring.

## Decision
We will build the frontend as a Single Page Application (SPA) 
using the following technology stack:
* **Core Framework:** React 18+
* **Language:** TypeScript
* **Build Tool:** Vite
* **Component Library & Styling:** Material UI (MUI) with Emotion
* **Data Fetching & State:** TanStack Query (React Query)
* **Deployment:** Containerized as static assets served by 
  an Nginx Alpine Docker container.

## Consequences

### Positive
* **Enterprise Standardization:** MUI is the undisputed industry 
  standard for corporate internal tools, immediately signaling 
  production readiness and architectural maturity.
* **Out-of-the-box Data Components:** MUI provides highly robust 
  Data Grids, Date Pickers, and complex form controls that are 
  essential for a school management system (e.g., fee ledgers, 
  attendance tracking) without building them from scratch.
* **Tooling Stability:** MUI installs cleanly as standard npm 
  dependencies (`@mui/material`), completely eliminating the CLI 
  workspace configuration and path alias bugs.
* **Strict Decoupling:** By remaining a Vite SPA, the UI stays a 
  stateless client consuming the API Gateway, yielding a highly 
  secure, lightweight Docker image.

### Negative
* **Bundle Size:** MUI is heavier than a pure Tailwind CSS build, 
  which may slightly increase initial client-side load times.
* **Styling Rigidity:** Overriding deep Material Design patterns 
  requires interacting with the Emotion styling engine rather than 
  applying simple utility classes.