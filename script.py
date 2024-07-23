#!/usr/bin/python3
import os
import subprocess
import time

path = '../Kafka/kafka_2.12-3.7.1/'
zookeeper = path + "bin/zookeeper-server-start.sh "+ path + "config/zookeeper.properties"
kafka_broker = path + "bin/kafka-server-start.sh " + path + "config/server.properties"
kafka_topic = path + "bin/kafka-topics.sh --create --topic messages --bootstrap-server localhost:9092"
kafka_monitor = path + "bin/kafka-topics.sh --describe --topic messages --bootstrap-server localhost:9092"

sh_scripts = [zookeeper, kafka_broker, kafka_topic, kafka_monitor]

def run_script(script, timeout):
    try:
        result = subprocess.run(
            ["bash", script],
            check=True,
            timeout=timeout,
            stdout=subprocess.PIPE,
            stderr=subprocess.PIPE
        )
        print(f"Script {script} finished successfully.")
        print("Output:", result.stdout.decode())
    except subprocess.TimeoutExpired:
        print(f"Script {script} timed out.")
    except subprocess.CalledProcessError as e:
        print(f"Script {script} failed with return code {e.returncode}.")
        print("Error output:", e.stderr.decode())


def exe():

    print("Starting zookeeper")
    os.system(path + "bin/zookeeper-server-start.sh "+ path + "config/zookeeper.properties")
    print("Starting kafka broker service")
    os.system(path + "bin/kafka-server-start.sh " + path + "config/server.properties")
    print("Creating Message")
    os.system(path + "bin/kafka-topics.sh --create --topic messages --bootstrap-server localhost:9092")
    print("the topic")
    os.system(path + "bin/kafka-topics.sh --describe --topic messages --bootstrap-server localhost:9092")

if __name__ == "__main__":
    print("Starting Kafka message broker")
    for script in sh_scripts:
        if os.path.isfile(script) and os.access(script, os.X_OK):
            print(f"Running {script}...")
            run_script(script, timeout)
        else:
            print(f"Script {script} not found or not executable.")

        # Small delay between scripts (optional)
        time.sleep(1)