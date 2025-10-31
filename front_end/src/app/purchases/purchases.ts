import { ChangeDetectorRef, Component } from '@angular/core';
import { PurchaseResponseDTO } from '../types/purchases/purchase-response-dto';
import { PurchaseService } from '../service/purchase-service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatTableModule } from '@angular/material/table';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatCard } from '@angular/material/card';
import { MatButton } from '@angular/material/button';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-purchases',
  imports: [
    CommonModule,
    FormsModule,
    MatTableModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatCard,
    MatButton,
  ],
  templateUrl: './purchases.html',
  styleUrl: './purchases.css',
})
export class Purchases {
  purchases: PurchaseResponseDTO[] = [];
  filters = {
    merchantId: 1,
    paymentMethod: '',
    fromDate: '',
    toDate: ''
  };
  displayedColumns: string[] = ['date', 'merchant', 'customer', 'payment', 'location', 'total'];
  error?: string;

  constructor(private readonly service: PurchaseService, private readonly cdr: ChangeDetectorRef, private readonly snackBar: MatSnackBar) { this.error = undefined }

  search(): void {
    this.service.getPurchases(this.filters).subscribe({
      next: (data) => {
        this.purchases = data;
        this.cdr.detectChanges();
      },
      error: (err) => {
        this.snackBar.open('Error al cargar compras', 'Cerrar', { duration: 3000 });

      }
    },);
  }

}
