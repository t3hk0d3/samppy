samppy
======

Java SMPP 5.0 implementation

Clear modular implementation of SMPP protocol.

Planned modules:
- samppy-proto - protocol entities and encoders/decoders. Only for PDU parsing/composing.
- samppy-session - SMPP session control. Both from SMSC and ESME sides.
- samppy-netty - netty specific adapters. Should let you write your SMPP-enabled applications using netty pretty much instantly.
