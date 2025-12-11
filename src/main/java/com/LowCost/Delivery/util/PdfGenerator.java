package com.LowCost.Delivery.util;


import com.LowCost.Delivery.model.InstantDeliveryOrder;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;

@Component
public class PdfGenerator {

    public byte[] generateOrderPdf(InstantDeliveryOrder order) throws Exception {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Document document = new Document();
        PdfWriter.getInstance(document, outputStream);

        document.open();

        Font titleFont = new Font(Font.HELVETICA, 22, Font.BOLD );
        Font normalFont = new Font(Font.HELVETICA, 12);

        Paragraph title = new Paragraph("Order Details\n\n", titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);

        document.add(new Paragraph("Order ID: " + order.getOrderId(), normalFont));
        document.add(new Paragraph("Date: " + order.getCreatedAt(), normalFont));
        document.add(new Paragraph("\n"));

        document.add(new Paragraph("Sender Information:", titleFont));
        document.add(new Paragraph("Name: " + order.getSenderName(), normalFont));
        document.add(new Paragraph("Phone: " + order.getSenderPhone(), normalFont));
        document.add(new Paragraph("Pickup Address: " + order.getPickupAddress(), normalFont));
        document.add(new Paragraph("Instructions: " + order.getSenderInstructions(), normalFont));
        document.add(new Paragraph("\n"));

        document.add(new Paragraph("Receiver Information:", titleFont));
        document.add(new Paragraph("Name: " + order.getReceiverName(), normalFont));
        document.add(new Paragraph("Phone: " + order.getReceiverPhone(), normalFont));
        document.add(new Paragraph("Delivery Address: " + order.getDeliveryAddress(), normalFont));
        document.add(new Paragraph("Landmark: " + order.getReceiverLandmark(), normalFont));
        document.add(new Paragraph("\n"));

        document.add(new Paragraph("Parcel Information:", titleFont));
        document.add(new Paragraph("Type: " + order.getParcelType(), normalFont));
        document.add(new Paragraph("Weight: " + order.getParcelWeight(), normalFont));
        document.add(new Paragraph("Delivery Time: " + order.getDeliveryTime(), normalFont));
        document.add(new Paragraph("Charge: " + order.getDeliveryCharge() + " ৳", normalFont));

        document.close();

        return outputStream.toByteArray();
    }
}
