export interface Bill {
    actualAmount: number;
    paidAmount: number;
    balance: number;
    message: string;
}

export interface BillObject {
    meterType: string;
    usageStartDate: string;
    usageEndDate: string;
    usageStartUnit: number;
    usageEndUnit: number;
    unitsUsed: number;
    noOfDays: number;
    bill: Bill;
}

export interface AverageBill {
    meterType: string;
    monthlyUsage: number;
}