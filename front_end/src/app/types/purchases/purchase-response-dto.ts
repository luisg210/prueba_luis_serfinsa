export interface PurchaseResponseDTO {
    id: number;
    merchantName: string;
    customerName: string;
    purchaseDate: string;
    paymentMethod: 'CASH' | 'CARD';
    location: string;
    totalAmount: number;

}
