import DangerButton from '@/Components/DangerButton';
import PrimaryButton from '@/Components/PrimaryButton';
import SecondaryButton from '@/Components/SecondaryButton';
import StudentList from '@/Components/StudentList';
import AuthenticatedLayout from '@/Layouts/AuthenticatedLayout';
import { Head } from '@inertiajs/react';

export default function Dashboard({ auth }) {
    return (
        <AuthenticatedLayout
            user={auth.user}
            header={<h2 className="font-semibold text-xl text-gray-800 dark:text-gray-200 leading-tight">Student Dashboard</h2>}
        >
            <Head title="Dashboard" />

            <div className="py-12">
                <div className="max-w-7xl mx-auto sm:px-6 lg:px-8">
                    <div className="bg-white dark:bg-gray-800 overflow-hidden shadow-sm sm:rounded-lg">
                        <div className="p-6 text-gray-900 dark:text-gray-100">
                            <div>
                                <form class="flex" method="POST" >
                                    <PrimaryButton>Add</PrimaryButton>
                                </form>
        
                                <div class="flex mt-5 py-4 justify-between">
                                    <div className='flex align-middle'>
                                        {auth.user.name}
                                    </div>
                                    <div>
                                        <SecondaryButton className='me-2'>Edit</SecondaryButton>
                                        <DangerButton>Delete</DangerButton>
                                    </div>
                                </div>
        
                            </div>
                        </div>
                        <div class="mt-5">
                        </div>
                    </div>
                </div>
            </div>
        </AuthenticatedLayout>
    );
}
