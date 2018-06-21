import { Directive, HostListener } from '@angular/core';

@Directive({
  selector: '[appEventClickStopPropagation]'
})
export class EventClickStopPropagationDirective {

  @HostListener('click', ['$event'])
  public onClick(event: any): void {
    event.stopPropagation();
  }
}
