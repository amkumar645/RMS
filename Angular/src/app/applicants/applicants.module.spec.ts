import { ApplicantsModule } from './applicants.module';

describe('ApplicantsModule', () => {
  let applicantsModule: ApplicantsModule;

  beforeEach(() => {
    applicantsModule = new ApplicantsModule();
  });

  it('should create an instance', () => {
    expect(applicantsModule).toBeTruthy();
  });
});
