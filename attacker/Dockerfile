FROM python:3.10-slim

ADD requirements.txt /tmp
RUN pip install -r /tmp/requirements.txt
WORKDIR /exploits

ENTRYPOINT [ "/bin/bash" ]