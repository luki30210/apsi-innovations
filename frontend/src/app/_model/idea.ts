import { Subject } from './subject';

export interface Idea {
  id: number;
  name: string;
  description: string;
  subject: Subject;
  keywords: string[];
  benefits: string;
  costs: string;
  additionDate: Date;
}
