#!/usr/bin/env bash

# Specify where we will install
# the certificate
SSL_DIR="/etc/ssl/amazonaws.com"

# Set the wildcarded domain
# we want to use
DOMAIN="*.amazonaws.com"

# A blank passphrase
PASSPHRASE=""

# Set our CSR variables
SUBJ="
C=NO
ST=Oslo
O=
localityName=Oslo
commonName=$DOMAIN
organizationalUnitName=
emailAddress=
"

# Create our SSL directory
# in case it doesn't exist
sudo mkdir -p "$SSL_DIR"

# Generate our Private Key, CSR and Certificate
sudo openssl genrsa -out "$SSL_DIR/amazonaws.com.key" 2048
sudo openssl req -new -subj "$(echo -n "$SUBJ" | tr "\n" "/")" -key "$SSL_DIR/amazonaws.com.key" -out "$SSL_DIR/amazonaws.com.csr" -passin pass:$PASSPHRASE
sudo openssl x509 -req -days 365 -in "$SSL_DIR/amazonaws.com.csr" -signkey "$SSL_DIR/amazonaws.com.key" -out "$SSL_DIR/amazonaws.com.crt"