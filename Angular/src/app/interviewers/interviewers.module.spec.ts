import { InterviewersModule } from './interviewers.module';

describe('InterviewersModule', () => {
  let interviewersModule: InterviewersModule;

  beforeEach(() => {
    interviewersModule = new InterviewersModule();
  });

  it('should create an instance', () => {
    expect(interviewersModule).toBeTruthy();
  });
});
