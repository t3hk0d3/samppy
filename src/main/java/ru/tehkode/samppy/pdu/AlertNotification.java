package ru.tehkode.samppy.pdu;

import ru.tehkode.samppy.proto.AbstractPDU;
import ru.tehkode.samppy.proto.NumericPlanIndicator;
import ru.tehkode.samppy.proto.SMPPCOctet;
import ru.tehkode.samppy.proto.SMPPCommand;
import ru.tehkode.samppy.proto.SMPPInteger;
import ru.tehkode.samppy.proto.TypeOfNumber;

public class AlertNotification extends AbstractPDU<AlertNotification> {

    @SMPPInteger(order = 0)
    private TypeOfNumber source_addr_ton;
    @SMPPInteger(order = 1)
    private NumericPlanIndicator source_addr_npi;
    @SMPPCOctet(order = 2, maxLength = 65)
    private String source_addr;
    @SMPPInteger(order = 3)
    private TypeOfNumber esme_addr_ton;
    @SMPPInteger(order = 4)
    private NumericPlanIndicator esme_addr_npi;
    @SMPPCOctet(order = 5, maxLength = 65)
    private String esme_addr;

    public long commandId() {
        return SMPPCommand.ALERT_NOTIFICATION.commandId();
    }

    public TypeOfNumber sourceAddrTON() {
        return this.source_addr_ton;
    }

    public AlertNotification sourceAddrTON(TypeOfNumber sourceAddrTon) {
        this.source_addr_ton = sourceAddrTon;

        return this;
    }

    public NumericPlanIndicator sourceAddrNPI() {
        return this.source_addr_npi;
    }

    public AlertNotification sourceAddrNPI(NumericPlanIndicator source_addr_npi) {
        this.source_addr_npi = source_addr_npi;

        return this;
    }

    public String sourceAddr() {
        return this.source_addr;
    }

    public AlertNotification sourceAddr(String source_addr) {
        this.source_addr = source_addr;

        return this;
    }

    public TypeOfNumber esmeAddrTON() {
        return this.esme_addr_ton;
    }

    public AlertNotification esmeAddrTON(TypeOfNumber esmeAddrTON) {
        this.esme_addr_ton = esmeAddrTON;

        return this;
    }

    public NumericPlanIndicator esmeAddrNPI() {
        return this.esme_addr_npi;
    }

    public AlertNotification esmeAddrNPI(NumericPlanIndicator esmeAddrNPI) {
        this.esme_addr_npi = esmeAddrNPI;

        return this;
    }

    public String esmeAddr() {
        return this.esme_addr;
    }

    public AlertNotification esmeAddr(String esmeAddr) {
        this.esme_addr = esme_addr;

        return this;
    }
}
