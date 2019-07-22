NOTES:

    1./ To create a multi-module project, copy/paste each individual application
        immediately under the master project. Then, edit the pom.xml of the master
        project using the tag hierarchy:
            <modules>
                <module></module>
                <module></module>
            </modules>

    2./ Set Auto Increment (AI) in the Primary Key of Table - in MySQL WorkBench

    3./ Launch Order:
        - Download (https://www.rabbitmq.com/download.html) & Launch Rabbit Message Broker Server
        - Launch Rabbit Producer
        - Launch Rabbit Consumer
