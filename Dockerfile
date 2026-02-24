# Stage 1: Build
FROM hseeberger/scala-sbt:17.0.2_1.6.2_2.13.8 AS builder
WORKDIR /app
COPY . .
RUN sbt clean stage

# Stage 2: Runtime
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=builder /app/target/universal/stage /app
CMD ["bin/my-sbt-project"]
