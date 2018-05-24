export interface Idea {
  id: number;
  name: string;
  description: string;
  subject: number;
  keywords: string[];
  benefits: string;
  costs: string;
  additionDate: Date;
}
