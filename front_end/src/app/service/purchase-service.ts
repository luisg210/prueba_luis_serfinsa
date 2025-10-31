import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PurchaseResponseDTO } from '../types/purchases/purchase-response-dto';

@Injectable({
  providedIn: 'root',
})
export class PurchaseService {
  private readonly apiUrl = 'http://localhost:8090/api/v1/purchases';

  constructor(private readonly http: HttpClient) { }

  getPurchases(filters: {
    merchantId: number;
    paymentMethod?: string;
    fromDate?: string;
    toDate?: string;
  }): Observable<PurchaseResponseDTO[]> {
    let params = new HttpParams().set('merchantId', filters.merchantId);

    if (filters.paymentMethod) params = params.set('paymentMethod', filters.paymentMethod);
    if (filters.fromDate) params = params.set('fromDate', filters.fromDate);
    if (filters.toDate) params = params.set('toDate', filters.toDate);

    return this.http.get<PurchaseResponseDTO[]>(this.apiUrl, { params });
  }

}
