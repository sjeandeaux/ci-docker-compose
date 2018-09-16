FROM debian:9.5


RUN echo 'slapd/root_password password password' | debconf-set-selections && \
    echo 'slapd/root_password_again password password' | debconf-set-selections && \
    echo 'slapd slapd/no_configuration boolean false' | debconf-set-selections && \
    echo 'slapd slapd/domain string ci.local' | debconf-set-selections && \
    echo 'slapd shared/organization string "ci"' | debconf-set-selections  && \
    echo 'slapd slapd/password1 password root_password' | debconf-set-selections && \
    echo 'slapd slapd/password2 password root_password' | debconf-set-selections && \
    echo 'slapd slapd/backend select HDB' | debconf-set-selections && \
    echo 'slapd slapd/purge_database boolean true' | debconf-set-selections  && \
    echo 'slapd slapd/allow_ldap_v2 boolean false' | debconf-set-selections  && \
    echo 'slapd slapd/move_old_database boolean false' | debconf-set-selections

RUN apt-get update -y &&\
    DEBIAN_FRONTEND=noninteractive LC_ALL=C \
    apt-get install -y procps \
    slapd ldap-utils && \
    rm -rf /var/lib/apt/lists/*

RUN echo 'BASE   dc=ci,dc=local' > /etc/ldap/ldap.conf && \
    echo 'URI    ldap://localhost' >> /etc/ldap/ldap.conf && \
    echo 'TLS_CACERT      /etc/ssl/certs/ca-certificates.crt' >> /etc/ldap/ldap.conf

EXPOSE 389 636

ENTRYPOINT ["slapd","-d","-1"]