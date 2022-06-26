import { Pipe, PipeTransform } from '@angular/core';
import { Job, JobPosition } from './admin-list/admin-list.component';

@Pipe({
  name: 'jobFilter'
})
export class JobFilterPipe implements PipeTransform {

  // Filters job/job positions
  transform(value: Job[], positions: JobPosition[], filterCategory: string, filterVal: string): Job[] {
    let filteredJobs: Job[] = [];
    if (filterCategory == "1") {
      value.forEach(job => {
        let position = positions.filter(position => position.id == job.jobPositionId)[0];
        if (position.name.indexOf(filterVal) != -1) 
          filteredJobs.push(job);
      });
    }
    if (filterCategory == "2") {
      value.forEach(job => {
        if (job.name.indexOf(filterVal) != -1) 
          filteredJobs.push(job);
      });
    }
    return filteredJobs;
  }

}
