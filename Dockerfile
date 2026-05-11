FROM bellsoft/liberica-openjre-alpine:21.0.10-cds

#workspace
WORKDIR /home/orange-asv-docker

#Add the required files
ADD target/orange-docker-resources ./

# Environment Variables
# BROWSER
# HUB_HOST
# TEST_SUITE
# THREAD_COUNT

# Run the tests
ENTRYPOINT java -cp "libs/*" \
    -Dselenium.grid.enabled=true \
    -Dselenium.grid.hubHost=${HUB_HOST} \
    -Dbrowser=${BROWSER} \
    org.testng.TestNG \
    -threadcount ${THREAD_COUNT} \
    suites/${TEST_SUITE}
